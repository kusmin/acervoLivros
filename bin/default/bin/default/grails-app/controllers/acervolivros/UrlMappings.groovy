package acervolivros

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        // "/apibuscar/v1/livro"(controller:"livro", action:"buscar")
        "/"(controller:"inicial", action:"index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
