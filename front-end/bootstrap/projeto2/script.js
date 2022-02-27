// Quando o documento estiver pronto, execute está função
$(document).ready(onReady);

// starta o documento js
function onReady()
{
    console.log('JQUERY LOAD');
    // esconde os elementos que tem a classe #retorno-cep (rua/bairro...)
    $('#retorno-cep').hide();
    // ao clicar fora do textfield "CEP"...
    $('#cep').on('blur', function(value)
    {
        // armazene dentro de uma variável o cep informado no campo de texto cep
        var inputCep = $('#cep');

        // imprime no console o cep informado
        // val serve tanto para informar um valor como setar
        console.log(inputCep.val());

        // se for válido, imprime a resposta da API
        buscaCEP(inputCep.val()).then(
            (response) => {
                console.log(response);
                if (response && response.cep !== '89053520')
                {
                    // seta nos campos com os respectivos ids, a resposta recebida pelo json de acordo com o cep informado
                    $('#retorno-cep').show();
                    $('#rua').val(response.logradouro);
                    $('#bairro').val(response.bairro);
                    $('#cidade').val(response.localidade);
                    $('#uf').val(response.uf);
                }
            }
        );
    });
}

// função assíncrona que contém a url da api, converte toda a api para json
async function buscaCEP(cep)
{
    var urlApi = `https://viacep.com.br/ws/${cep}/json/`;

    return fetch(urlApi).then(resp => resp.json());
}

