## ScreenMatch

Usando boas práticas de desenvolvimento (injeção de dependência e responsabilidades em camadas)  
model: camada de entidades e mapeamento das colunas  
repository: camada de interface para uso do JPA (buscas via derived queries e JPQL)  
service: camada de consumo de api's e conversão de dados  
principal: camada mais importante onde possui toda a regra e orquestração das entidades com o banco de dados  

### Este projeto utiliza:  
Consumo da api (omdb)  
Tradução para português da sinopse usando IA generativa    
Persistência no banco de dados postgres via JPA  

### FUNCIONALIDADES DO PROJETO  
Este projeto possui interação com o usuário via terminal, onde é possível:  

Buscar séries  (quando encontrado no omdb a série é persistida no banco de dados)  
Buscar episódios da série  (quando encontrado no omdb a série é persistida no banco de dados)  
Listar histórico de séries salvas no banco de dados 
Buscar série por título  
Buscar séries por ator  
Buscar top 5 séries  
Buscar série por categoria  
Filtrar série por temporada e avaliação  
Buscar por episódio  
Buscar top 5 episódios por série  

### Antes de rodar a API:  
Esta api conta com o JDK na versão 17  

Variáveis de ambiente:  
para uso do gemini  
```
GEMINI_API_KEY=
MODEL=
```

para uso do omdb  
```
API_KEY=
ENDERECO_OMDB=
```

para consumo do banco de dados postgres  
```
export DB_HOST=
export DB_NAME=
export DB_USER=
export DB_PASSWORD=
```
