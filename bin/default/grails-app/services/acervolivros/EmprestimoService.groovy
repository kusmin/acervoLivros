package acervolivros

import grails.gorm.services.Service

@Service(Emprestimo)
interface EmprestimoService {

    Emprestimo get(Serializable id)

    List<Emprestimo> list(Map args)

    Long count()

    void delete(Serializable id)

    Emprestimo save(Emprestimo emprestimo)

}