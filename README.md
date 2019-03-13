# sd_fisica

Trabalho de Sistemas Distribuídos utilizando Acelerômetro

O projeto consiste na implementação de um sistema distribuído usando a tecnologia do acelerômetro para coletar e exibir dados de aceleração através de forças de vibrações nos 3 eixos que compõem o acelerômetro.

Neste projeto, para coletar os dados é utilizado um aplicativo móvel desenvolvido para sistema Android rodando em um dispositivo que possua o sensor Acelerômetro. O aplicativo tem a função de iniciar captura, calibrar os eixos X, Y e Z para iniciar suas posições do 0 independente da orientação em que o dispositivo se encontra e a função de enviar os dados para um servidor no qual será usado para receber e exibir os dados.

O servidor é uma aplicação desktop desenvolvido em Java, tem a função de receber os dados de um dispositivo e exibir na tela em forma de texto em um console e em forma de gráfico em um painel, sendo possível também salvar o gráfico como arquivo de imagem.

A comunicação entre cliente e servidor é realizada através de uma rede local utilizando Sockets para a conexão e transferência de dados.
