CREATE USER 'admin_proyecto'@'localhost' IDENTIFIED BY 'admin_clave';

GRANT ALL PRIVILEGES ON gymapp.* TO 'admin_proyecto'@'localhost';

FLUSH PRIVILEGES;