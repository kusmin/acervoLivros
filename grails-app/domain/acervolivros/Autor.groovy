package acervolivros

class Autor {

    String nome
    String bibliografia

    static constraints = {
        nome nullable:false, blank:false, maxSize:128, unique:true
        bibliografia nullable:true, blank:true
    }
}
