<g:set var="livros" value="${acervolivros.Livro?.list()}"/>

<g:if test="${ livros }">
   <table class="table">
        <thead>
            <tr>
                <th>Codigo</th>
                <th>Titulo</th>
                <th>Categoria</th>
                <th>Autor</th>
                <th>Descrição</th>
                <th>Tempo de Cadastro</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${livros}" var="livro" status="i">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:link method="GET" action="edit" id="${livro?.id}">${livro?.codigo}</g:link></td>
                    <td>${livro?.titulo}</td>
                    <td><g:link method="GET" action="show" id="${livro?.categoria?.id}">${livro.categoria.nome}</g:link></td>
                    <td><g:link method="GET" action="show" id="${livro?.autor?.id}">${livro.autor.nome}</g:link></td>
                    <td>${livro?.descricao}</td>
                </tr>
            </g:each>
        </tbody>
    </table>
</g:if>
