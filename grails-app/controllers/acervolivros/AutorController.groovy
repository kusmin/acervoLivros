package acervolivros

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class AutorController {

    AutorService autorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", buscar: "GET"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond autorService.list(params), model:[autorCount: autorService.count()]
    }

    def show(Long id) {
        respond autorService.get(id)
    }

    def create() {
        respond new Autor(params)
    }

    def buscar(){
        if(!params.nome && !params.bibliografia){
            def error = ["Erro": "Escolha uma opção de busca"]
            render error as JSON
            return
        }

        def resultado = Autor.withCriteria(max:10, offset: 10){
            if(params.nome){
                ilike "nome","%${params.nome}%"
            }
            if(params.bibliografia){
                ilike "bibliografia","%${params.bibliografia}%"
            }
            order "nome", "asc"
        }
        render resultado as JSON
    }

    // def upload() {
    //     def f = request.getFile('foto')
    //     if (f.empty) {
    //         flash.message = 'Não teve nenhum arquivo para upload'
    //         render(view: 'create')
    //         return
    //     }

    //     f.transferTo(new File('/some/local/dir/foto.txt'))
    //     response.sendError(200, 'Done')
    // }

    def save(Autor autor) {
        if (autor == null) {
            notFound()
            return
        }

        try {
            autorService.save(autor)
            response.status = 201
            
        } catch (ValidationException e) {
            respond autor.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'autor.label', default: 'Autor'), autor.id])
                redirect autor
            }
            '*' { respond autor, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond autorService.get(id)
    }

    def update(Autor autor) {
        if (autor == null) {
            notFound()
            return
        }

        try {
            autorService.save(autor)
        } catch (ValidationException e) {
            respond autor.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'autor.label', default: 'Autor'), autor.id])
                redirect autor
            }
            '*'{ respond autor, [status: OK] }
        }
    }


    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        autorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'autor.label', default: 'Autor'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'autor.label', default: 'Autor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
