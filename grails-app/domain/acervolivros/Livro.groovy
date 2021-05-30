package acervolivros
import java.time.LocalDate

class Livro {

    String titulo
    String descricao
    int codigo
    LocalDate dataCadastro = LocalDate.now()
    String foto

    String toString(){
        this.titulo
    }

    static hasMany =[categoria:Categoria, autor:Autor]

    static constraints = {
        categoria nullable:false, blank:false, unique:false
        autor nullable:false, blank:false
        titulo nullable:false, blank:false, unique:true, maxSize:128
        descricao nullable:true, blank:true
        codigo nullable:false, blank:false, unique:true, maxSize:64
        dataCadastro nullable:false, blank:false
        foto nullable:true, blank:true 
    }

    static mapping = {
        table 'livros'
    }
}