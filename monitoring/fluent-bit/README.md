If you are using Minikube, make sure that its started properly by running this command (for mac):  
```minikube start --vm-driver=hyperkit```  

Now set the Minikube context. The context is what determines which cluster kubectl is interacting with.  
```kubectl config use-context minikube```  

Verify that kubectl is configured to communicate with your cluster:  
```kubectl cluster-info```  

To view the nodes in the cluster, run:  
```kubectl get nodes```  

## Kubernetes Dashboard
Minikube includes the kubernetes dashboard as an addon which you can enable.

```minikube addons list```
* returns
```
- default-storageclass: enabled
- coredns: disabled
- kube-dns: enabled
- ingress: disabled
- registry: disabled
- registry-creds: disabled
- addon-manager: enabled
- dashboard: enabled
- storage-provisioner: enabled
- heapster: disabled
- efk: disabled
```

You can enable an addon using:

```minikube addons enable dashboard```  

You can then open the dashboard with command  
```minikube addons open dashboard```


Store the output of any resources in yaml  
```kubectl get pod qos-demo --namespace=qos-example --output=yaml```