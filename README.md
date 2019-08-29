# Getting Started

### Create new MySQL user
CREATE USER 'library'@'localhost' IDENTIFIED BY 'library';
GRANT ALL PRIVILEGES ON * . * TO 'library'@'localhost';
FLUSH PRIVILEGES;

### Connection String
?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
