package acervolivros

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import java.time.*


class EmprestimoController {

    EmprestimoService emprestimoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond emprestimoService.list(params), model:[emprestimoCount: emprestimoService.count()]
    }

    def tempoDeEmprestimo(Long id){
        def emprestimo = emprestimoService.get(id)
        def diaPegouEmprestado = emprestimo.dataCadastroEmprestimo
        LocalDate atual = LocalDate.now()
        Period periodo = Period.between(diaPegouEmprestado, atual)
        def diferenca = ["${emprestimo.livro}": periodo.getDays()]
        render diferenca as JSON
    }

    def show(Long id) {
        respond emprestimoService.get(id)
    }

    def create() {
        respond new Emprestimo(params)
    }

    def save(Emprestimo emprestimo) {
        if (emprestimo == null) {
            notFound()
            return
        }

        try {
            emprestimoService.save(emprestimo)
        } catch (ValidationException e) {
            respond emprestimo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'emprestimo.label', default: 'Emprestimo'), emprestimo.id])
                redirect emprestimo
            }
            '*' { respond emprestimo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond emprestimoService.get(id)
    }

    def update(Emprestimo emprestimo) {
        if (emprestimo == null) {
            notFound()
            return
        }

        try {
            emprestimoService.save(emprestimo)
        } catch (ValidationException e) {
            respond emprestimo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'emprestimo.label', default: 'Emprestimo'), emprestimo.id])
                redirect emprestimo
            }
            '*'{ respond emprestimo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        emprestimoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'emprestimo.label', default: 'Emprestimo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'emprestimo.label', default: 'Emprestimo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
