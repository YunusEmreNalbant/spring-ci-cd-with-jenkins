#  CI/CD Pipeline With Jenkins

## Proje Hakkında

Bu proje, Spring Boot tabanlı bir uygulamanın Jenkins kullanılarak Continuous Integration (CI) ve Continuous Deployment (CD) süreçlerinin nasıl otomatize edileceğini göstermektedir. Pipeline, uygulamanın önce Maven ile derlenmesini, Docker imajının oluşturulmasını ve sonrasında Docker Hub'a gönderilmesini sağlar. Bu sayede, her yeni commit sonrası uygulamanızın en güncel versiyonu otomatik olarak Docker Hub'da yayınlanır ve dağıtıma hazır hale gelir.

### Gereksinimler
- **Jenkins** (CI/CD işlemleri için)
- **Maven** (Spring Boot uygulamasını derlemek için)
- **Docker** (Uygulamayı konteynerleştirmek ve Docker Hub'a göndermek için)
- **Docker Hub Hesabı** (Docker imajlarını paylaşmak için)
- **ngrok** (Jenkins'i dış dünyaya açmak ve webhook bağlantısını sağlamak için)


### Jenkins Webhook ile Otomatik Build

Projenizde her yeni commit yaptığınızda Jenkins pipeline'ının otomatik olarak çalışması için GitHub üzerinde bir **Webhook** eklenmiştir. Bu webhook, Jenkins'e yapılan her push işlemini haber verir ve pipeline'ın tetiklenmesini sağlar.


#### Webhook Kurulumu

1. **ngrok** kullanarak Jenkins'inize dış dünyadan erişim sağladım. Jenkins'iniz lokal ortamda çalıştığında dışarıya bir URL verebilmek için `ngrok` ile geçici bir HTTP tüneli açabilirsiniz. Aşağıdaki komut ile `ngrok` üzerinden Jenkins'inize ulaşılabilir bir URL elde edebilirsiniz:

    ```bash
    ngrok http <jenkins_port>
    ```

   Örneğin, Jenkins'iniz varsayılan olarak `8080` portunda çalışıyorsa:

    ```bash
    ngrok http 8080
    ```

   Bu komut size bir URL verecektir (örneğin: `https://abcd1234.ngrok.io`). Bu URL'yi GitHub Webhook ayarlarında kullanabilirsiniz.

2. GitHub'da proje ayarlarına gidin ve **Settings** > **Webhooks** kısmında yeni bir webhook ekleyin.
3. **Payload URL** kısmına ngrok tarafından verilen URL'yi kullanarak şu şekilde girin:

    ```
    https://abcd1234.ngrok.io/github-webhook/
    ```

4. Content type olarak **application/x-www-form-urlencoded** seçebilirsiniz.
5. Son olarak, hangi eventlerde tetikleneceğini seçin. **Just the push event** seçeneği işaretlenmiş olmalı.

### Kimlik Bilgilerinin Yönetimi

Pipeline'da kullanılan Docker Hub kimlik bilgileri, Jenkins'in `withCredentials` bloğu içerisinde güvenli bir şekilde yönetilmektedir. `dockerhub-pwd` olarak tanımlanan kimlik bilgileri, Jenkins'in **Credentials** bölümüne eklenmeli ve burada güvenli bir şekilde saklanmalıdır. Bu sayede, Docker Hub'a giriş yapmak için şifrenizi doğrudan kodda belirtmenize gerek kalmaz.

### Pipeline'ın Çalıştırılması

1. Jenkins'te yeni bir pipeline projesi oluşturun.
2. Yukarıdaki pipeline kodunu Jenkins'e yapıştırın.
3. `dockerhub-pwd` kimlik bilgilerini Jenkins'te ekleyin.
4. Pipeline'ı çalıştırın. Jenkins, projenizi otomatik olarak derleyecek, Docker imajını oluşturacak ve Docker Hub'a gönderecektir.

## Sonuç

Bu proje, Spring Boot uygulamalarınız için CI/CD süreçlerini otomatize ederek, geliştirme döngüsünü hızlandırmayı amaçlamaktadır. Her yeni commit ile birlikte uygulamanızın en güncel versiyonu Docker Hub'da yayınlanacak ve dağıtıma hazır hale gelecektir. Pipeline'da kullanılan her adım, geliştirme ve devops süreçlerini daha verimli ve sorunsuz hale getirmek için tasarlanmıştır.


### Kimlik Bilgilerinin Yönetimi

Pipeline'da kullanılan Docker Hub kimlik bilgileri, Jenkins'in `withCredentials` bloğu içerisinde güvenli bir şekilde yönetilmektedir. `dockerhub-pwd` olarak tanımlanan kimlik bilgileri, Jenkins'in **Credentials** bölümüne eklenmeli ve burada güvenli bir şekilde saklanmalıdır. Bu sayede, Docker Hub'a giriş yapmak için şifrenizi doğrudan kodda belirtmenize gerek kalmaz.

## Özetle

Bu proje, Spring Boot uygulamalarınız için CI/CD süreçlerini otomatize ederek, geliştirme döngüsünü hızlandırmayı amaçlamaktadır. Her main branch'ine yapılan yeni push ile birlikte uygulamanızın en güncel versiyonu Docker Hub'da yayınlanacak ve dağıtıma hazır hale gelecektir. Pipeline'da kullanılan her adım, geliştirme ve devops süreçlerini daha verimli ve sorunsuz hale getirmek için tasarlanmıştır.
