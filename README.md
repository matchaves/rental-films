# Rental-rental

branch com initial conf application.yaml

```
base-path /films
```

```
GET /
endpoint lista todos filmes no catalogo
```

```
GET /availables
lista todos filmes disponivel em estoque para alugar
```

```
GET /{id}
GET /films?id=X
get film por id
```

```
GET /cost
get custo de alocação do filme por film_id
```

```
GET /availablesbystore/{store_id}
get lista de filmes disponiveis para alugar por store_id
```

branch com initial conf application.yaml com jib configurado

###CMD BUILD USANDO JIB PARA BUILD DOCKER IMAGE COM A TAG PASSADA VIA ARGUMENTO
gradle jibDockerBuild -Ptag=100 # tag do build da imagem docker

###CMD RODA CONTAINER SETANDO O IP DO PG E A PORTA PARA A API CONECTAR NO BANCO
###VARIAVEIS IP_PG e PORT ESTÃO REFERENCIADAS NO application.yaml
docker run -d --name customer --env ip_pg=192.160.XX.XX --env PORT=5436  colabdevops/rental:1