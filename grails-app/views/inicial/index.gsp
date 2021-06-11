<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Home</title>
</head>
<body>
    <div class="container">

        <div class="row mt-3">
        
                <div class="col">
                    <h2>Sobre mim</h2>
                    <section>

                        <p>
                        Programador, jogador de xadrez na horas vagas, amante de bons livros e de bons vinhos rsrs. 
                        Tenho como objetivo de vida promover as mudanças na sociedade atraves da disseminação do conhecimento e da tecnologia, seja essa tecnologia atual ou antiga.
                        </p>

                    </section>
                </div>
                <div class="col">
                    <h2>Sobre o sistema</h2>

                    <section>

                        <p>
                        Um sistema bem simples para controle de livros e disseminação do emprestimo de livros.
                        Uma maneira de compartilhar livros sem perder o controle sobre onde estão.
                        </p>

                    </section>
                </div>
            </div>
        <div class="card mt-4 mb-4 p-2">
            <g:set var="livros" value="${acervolivros?.Livro?.count()}" />
            <g:set var="emprestimo" value="${acervolivros?.Emprestimo?.count()}" />
            <g:set var="categorias" value="${acervolivros?.Categoria?.count()}" />
            <g:set var="autores" value="${acervolivros?.Autor?.count()}" />
            <g:set var="usuarios" value="${acervolivros?.Usuario?.count()}" />
            <g:set var="disponiveis" value="${livros - emprestimo}" />


            <h2 class="card-title">Informações sobre a biblioteca</h2>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Livros emprestados ${emprestimo}</li>
                    <li class="list-group-item">Livros disponiveis ${disponiveis}</li>
                    <li class="list-group-item">Total de livros ${livros}</li>
                    <li class="list-group-item">Total de autores ${autores}</li>
                    <li class="list-group-item">Total de categorias de livros ${categorias}</li>

                </ul>
        </div>
    </div>
</body>
</html>
