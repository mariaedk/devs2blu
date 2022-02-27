var user =
{
    login: '',
    senha: '',
    logado: false
}

// Quando o documento estiver pronto, execute está função
$(document).ready(onReady);

// starta o documento js
function onReady()
{
    console.log('JQUERY LOAD');
    verificaLogin();

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

function realizarLogin()
{
    console.log('Login realizado');
    createDestroyLoading();
    var login = $('#login').val();
    var senha = $('#senha').val();
    
    if (login && senha)
    {
        user.login = login;
        user.senha = senha;
        user.logado = true;
        user = 
        {
            login, senha, logado: true
        };
        console.log(user);
        inserir('user', JSON.stringify(user));
    }

    createDestroyLoading(true);
}

function createDestroyLoading(destroy = false)
{
    if (!destroy)
    {
        // executa o login
        var loadingDiv = document.createElement('div');
        var imgLoading = document.createElement('img');

        $(imgLoading).attr('src', '_img/loading2.gif');
        $(loadingDiv).append(imgLoading);
        $(loadingDiv).attr('class', 'loading');
        // inserindo a div no body
        $('body').append(loadingDiv);
        console.log(loadingDiv);
    }
    else
    {
        // vai carregar a imagem do loading por 3s, e dps remove ela
        setTimeout(() => $('.loading').remove(), 3000);
    }
}

function verificaLogin()
{
    if (get('user'))
    {
        $('#formLoginDiv').hide();
    }
}

// storage functions

function inserir(key, value)
{
    //verifica se existe o item
    // "Update"
    if (localStorage.getItem(key))
    {
        localStorage.removeItem(key);
        localStorage.setItem(key, value);
    }

    // "insert"
    else
    {
        localStorage.setItem(key, value);
    }
}

// "delete"
function remover(key)
{
    localStorage.removeItem(key);
}

// "get"
function get(key)
{
    localStorage.getItem(key);
}
