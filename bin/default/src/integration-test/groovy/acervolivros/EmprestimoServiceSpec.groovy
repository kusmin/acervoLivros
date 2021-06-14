package acervolivros

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmprestimoServiceSpec extends Specification {

    EmprestimoService emprestimoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Emprestimo(...).save(flush: true, failOnError: true)
        //new Emprestimo(...).save(flush: true, failOnError: true)
        //Emprestimo emprestimo = new Emprestimo(...).save(flush: true, failOnError: true)
        //new Emprestimo(...).save(flush: true, failOnError: true)
        //new Emprestimo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //emprestimo.id
    }

    void "test get"() {
        setupData()

        expect:
        emprestimoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Emprestimo> emprestimoList = emprestimoService.list(max: 2, offset: 2)

        then:
        emprestimoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        emprestimoService.count() == 5
    }

    void "test delete"() {
        Long emprestimoId = setupData()

        expect:
        emprestimoService.count() == 5

        when:
        emprestimoService.delete(emprestimoId)
        sessionFactory.currentSession.flush()

        then:
        emprestimoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Emprestimo emprestimo = new Emprestimo()
        emprestimoService.save(emprestimo)

        then:
        emprestimo.id != null
    }
}
