package acervolivros

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import java.time.*

class LivroController {

    LivroService livroService
    LivroDataService livroDataService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond livroService.list(params), model:[livroCount: livroService.count()]
    }

    def show(Long id) {
        respond livroService.get(id)
    }

    def create() {
        respond new Livro(params)
    }

    def tempoDeCadastro(Long id){
        def livro = livroService.get(id)
        def tempoDeCadastro = livro.dataCadastro
        LocalDate atual = LocalDate.now()
        Period periodo = Period.between(tempoDeCadastro, atual)
        def diferenca = ["${livro.titulo}" : periodo.getDays()]
        render diferenca as JSON
    }

    def buscar(){
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

    def categoriaPorLivro(){
        def categoriaPorLivro = Livro.withCriteria(){
        
        projections{
            groupProperty 'categoria.id'
            count 'categoria'
            }    
        
        }

        render categoriaPorLivro as JSON
    }


    def save(Livro livro) {
        if (livro == null) {
            notFound()
            return
        }

        try {
            livroService.save(livro)
        } catch (ValidationException e) {
            respond livro.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'livro.label', default: 'Livro'), livro.id])
                redirect livro
            }
            '*' { respond livro, [status: CREATED] }
        }
    }

    def editImages(Long id) {
    Livro livro = livroDataService.get(id)
    if (!livro) {
        notFound()
    }
    [livro: livro]
    }

    def uploadImage(FeaturedImageCommand image){
        if(image == null){
            notFound()
            return
        }
        if(image.hasErrors()){
            respond(image.errors, model:[livro: image], view: 'editImage')
        }

        Livro livro = livroDataService.update(
                image.id,
                image.version,
                image.featuredImageFile.bytes,
                image.featuredImageFile.contentType
            )
            if(image == null){
            notFound()
            return
        }
        if(livro.hasErrors()){
            respond(livro.errors, model:[livro: livro], view: 'editImage')
        }

        Locale locale = request.locale
        ​redirect(controller: "livro", action: "index")
    }

    def featuredImage(Long id) {
    Livro livro = livroDataService.get(id)
    if (!livro || livro.capaByte == null) {
        notFound()
        return
    }
    log.info "${livro.capaByte}"
    log.info "${livro.capaString}"

    render file: livro.capaByte,
        contentType: livro.capaString
}

    def edit(Long id) {
        respond livroService.get(id)
    }

    def update(Livro livro) {
        if (livro == null) {
            notFound()
            return
        }

        try {
            livroService.save(livro)
        } catch (ValidationException e) {
            respond livro.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'livro.label', default: 'Livro'), livro.id])
                redirect livro
            }
            '*'{ respond livro, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        livroService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'livro.label', default: 'Livro'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'livro.label', default: 'Livro'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
