# Getting Started

### Create new MySQL user
CREATE USER 'library'@'%' IDENTIFIED BY 'library';
GRANT ALL PRIVILEGES ON * . * TO 'library'@'%';
FLUSH PRIVILEGES;

### Connection String
?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
