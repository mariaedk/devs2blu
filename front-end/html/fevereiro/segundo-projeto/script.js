/*
console.log('javascript iniciado');

var texto = 'texto JS';
// Segurar alt e flecha para cima/baixo para mover texto
console.log(texto);

texto = {
    id: 1,
    textoHTML: 'Meu texto objeto'
};
// Agora, 'texto' é um objeto
console.log(texto);

// adiciona uma nova propriedade
texto.atualizado = true;

console.log(texto);

// criou um método


texto.exibeTexto = function()
{
    console.log(this.id + ' ' + this.textoHTML + ' ' + this.atualizado);
    alert(this.id + ' ' + this.textoHTML + ' ' + this.atualizado);
}
*/

// texto.exibeTexto();


console.log(document);

// var cria variavel global
// let cria variavel local
// const = constante

var quadradoRoxo = document.getElementById('quadrado1');
var quadradoPreto = document.getElementsByClassName('quadrado');

posicionaQuadrados(quadradoPreto);

quadradoRoxo.style.width = '100px';
quadradoRoxo.style.height = '100px';

function posicionaQuadrados(collection)
{
    for (let i = 0; i < collection.length; i++) 
    {
        const element = collection[i];
        console.log(element);
        element.style.top = retornaPosicao();
        element.style.left = retornaPosicao();
        // element.style.display = 'block';
    }
}

function retornaPosicao()
{
    var medida = 470;
    var medidaRetorno;

    // === valor e tipo iguais
    //==  valor igual
    medidaRetorno = Math.random() * (medida - 30) + 0;

    return `${medidaRetorno}px`;
}


