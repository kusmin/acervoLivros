package acervolivros

import grails.gorm.services.Service

@Service(Livro)
interface LivroDataService {
    Livro get(Long id)
    List<Livro> list(Map args)
    Number count()
    void delete(Serializable id)
    Livro update(Serializable id, Long version, String titulo, String descricao, Integer codigo)
    Livro update(Serializable id, Long version, byte[] capaByte, String capaString) 
    Livro save(String titulo, String descricao, Integer codigo)
}