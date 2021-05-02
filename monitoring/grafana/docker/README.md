Execute -   
`docker run -d \
       -p 3000:3000 \
       --name=grafana \
       -e "GF_INSTALL_PLUGINS=http://plugin-domain.com/my-custom-plugin.zip;custom-plugin" \
       grafana/grafana`
       
       
> #### For more info
> [Grafana Installation](https://grafana.com/docs/grafana/latest/installation/docker/)       
> [Grafna GITHUB](https://github.com/grafana/grafana/tree/master/packaging)