<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>
<header class="header mb-4" style="height: 100px !important;">
        <nav class="mh-100 navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation" style="height: 100px !important;">
            <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
            <g:link class="navbar-brand media mt-3" action="index"><asset:image class="img-fluid" src="livros.jpeg" alt="livros" width= "100" height="50"/></g:link>
                <ul class="nav navbar-nav ml-auto">
                    <li><g:link controller="livro" action="index">Livros</g:link></li>
                    <li><g:link controller="categoria" action="index">Categorias</g:link></li>
                    <li><g:link controller="emprestimo" action="index">Emprestimos</g:link></li>
                    <li><g:link controller="autor" action="index">Autores</g:link></li>
                    <li><g:link controller="usuario" action="index">Usuarios</g:link></li>
                </ul>
            </div>

        </nav>
</header>

<g:layoutBody/>

<footer class="footer column mt-4" role="contentinfo" style="max-height: 100px !important;">
        <nav class="mh-100 navbar navbar-expand-lg navbar-dark" role="navigation" style="max-height: 80px !important;">
            <div></div>    
            <div class="row">
                <h3 class="m-0 mx-auto m">Redes sociais</h3>
                <div class="row">
                    <g:link class="navbar-brand media" uri="www.linkedin.com/in/renan-ribeiro-b1368872/" base="http://"><asset:image class="img-fluid m-0 p-0" src="linkedin-svgrepo-com.svg" alt="linkedin" width= "30" height="30"/></g:link>
                    <g:link class="navbar-brand media" uri="github.com/kusmin" base="http://"><asset:image class="img-fluid m-0 p-0" src="iconmonstr-github-1.svg" alt="github" width= "30" height="30"/></g:link>
                    <g:link class="navbar-brand media" uri="m.facebook.com/renan.lage.54" base="http://"><asset:image class="img-fluid m-0 p-0" src="facebook_108044.svg" alt="facebook" width= "30" height="30"/></g:link>
                    <g:link class="navbar-brand media" uri="www.instagram.com/renan.lagee/" base="http://"><asset:image class="img-fluid m-0 p-0" src="instagram_108043.svg" alt="instagram" width= "30" height="30"/></g:link>
                    <g:link class="navbar-brand media" uri="api.whatsapp.com/send?phone=5531989791428&text=Ol%C3%A1%2C%20tudo%20bem%20%3F%20Te%20vi%20no%20http%3A%2F%2Fblogdopensadormoderno.com.br%2F" base="http://"><asset:image class="img-fluid m-0 p-0" src="whatsapp_108042.svg" alt="whatsapp" width= "30" height="30"/></g:link>
                    <g:link class="navbar-brand media" uri="www.youtube.com/channel/UCfVcQjS_9l8EbWKkp8R8ysQ" base="http://"><asset:image class="img-fluid m-0 p-0" src="youtube_108041.svg" alt="youtube" width= "30" height="30"/></g:link>
                <div>
            </div>
        </nav>
</footer>



<asset:javascript src="application.js"/>

</body>
</html>
