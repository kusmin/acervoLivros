package acervolivros
import java.time.LocalDate

class Livro {

    String titulo
    String descricao
    Integer codigo
    LocalDate dataCadastro = LocalDate.now()
    byte[] capaByte
    String capaString
    // Byte contracapaByte
    
    // String contracapaString

    String toString(){
        this.titulo
    }

    static belongsTo =[categoria:Categoria, autor:Autor]

    static constraints = {
        categoria nullable:false, blank:false, unique:false
        autor nullable:false, blank:false
        titulo nullable:false, blank:false, unique:true, maxSize:128
        descricao nullable:true, blank:true
        codigo nullable:false, blank:false, unique:true, maxSize:64
        dataCadastro nullable:false, blank:false
        capaByte nullable:true, blank:true, maxSize: 25 * 1024 * 1024 
        // contracapaByte nullable:true, blank:true, maxSize: 25 * 1024 * 1024
        capaString nullable:true
        // contracapaString nullable:true
    }

    static mapping = {
        table 'livro'
        capaByte column: 'capa_byte', sqlType: 'longblob'
        // contracapaByte column: 'contracapa_byte'
        capaString column: 'capa_string'
        // contracapaString column: 'contracapa_string', sqlType: 'longblob'
    }
}