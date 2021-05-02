`$ docker build -t fluent-bit .`

```
$ docker run -p 24224:24224 \   
        -v {path_to_your_log_file}:/fluent-bit/{log_file_name} \   
        --name fluent-bit fluent-bit
```