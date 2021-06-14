package acervolivros

import grails.converters.JSON


class BuscarController {

    static allowedMethods = [busca: "GET"]

    def busca(){
        if(!params.titulo && !params.descricao && !params.codigo){
            def error = ["Erro": "Escolha uma opção de busca"]
            render error as JSON
            return
        }

        def resultado = Livro.withCriteria(max:10, offset: 10){
            if(params.titulo){
                ilike "titulo","%${params.titulo}%"
            }
            if(params.descricao){
                ilike "descricao","%${params.descricao}%"
            }
            if(params.codigo){
                ilike "codigo","%${params.codigo}%"
            }
            order "titulo", "asc"
        }
        render resultado as JSON
    }
}
