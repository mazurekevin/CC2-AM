# CC2-AM

MAZURE Kévin  
HALIFA Halisia  
LYS-PHORIMAVONG Jean-Luc   
CAROLE Luigi


Nous avons tout d'abord généré le projet avec Swagger afin de simplifier le développement de l'API.
Nous avons créé 2 routes pour notre Paiement : une POST afin d'envoyer le paiement et une GET afin de vérifier si le paiement existe déjà (Idempotence).
Nous avons mis en place Redis dans notre projet mais nous avons rencontré des problèmes de compatibilité avec Swagger.
Pour prouver que Redis fonctionne correctement, nous avons recréé les routes manuellement dans les classes PaymentController et PaymentRepository.
