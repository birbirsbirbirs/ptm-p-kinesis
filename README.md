### https://github.com/spring-cloud/spring-cloud-stream-binder-aws-kinesis/blob/main/spring-cloud-stream-binder-kinesis-docs/src/main/asciidoc/overview.adoc

```shell
docker compose up -d
```
```shell
docker compose down
```
```shell
aws --endpoint-url=http://localhost:4566 kinesis create-stream --stream-name ptm-kinesis --shard-count 4
```
```shell
aws --endpoint-url=http://localhost:4566 kinesis list-streams
```
```shell
al kinesis describe-stream --stream-name ptm-kinesis
```
```shell
echo -n 'my-data' | base64
```
```shell
al kinesis put-record --stream-name ptm-kinesis --partition-key my-partition-key --data "eyJuYW1lIjoibXktZGF0YSJ9" --explicit-hash-key "255211775190703847597530955573826158589"
```
```shell
al kinesis put-record --stream-name ptm-kinesis --partition-key my-partition-key --data "eyJuYW1lIjoibXktZGF0YSJ9" --explicit-hash-key "170141183460469231731687303715884105726"
```
```shell
al kinesis put-record --stream-name ptm-kinesis --partition-key my-partition-key --data "eyJuYW1lIjoibXktZGF0YSJ9" --explicit-hash-key "85070591730234615865843651857942052863"
```