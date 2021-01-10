# nachrichtenleicht-api [![Build Status](https://travis-ci.org/Frederick-S/nachrichtenleicht-api.svg?branch=main)](https://travis-ci.org/Frederick-S/nachrichtenleicht-api) [![Build status](https://ci.appveyor.com/api/projects/status/hc99xfxmvoco8kmi/branch/main?svg=true)](https://ci.appveyor.com/project/Frederick-S/nachrichtenleicht-api/branch/main) [![codecov](https://codecov.io/gh/Frederick-S/nachrichtenleicht-api/branch/main/graph/badge.svg?token=JQe78ujAzz)](https://codecov.io/gh/Frederick-S/nachrichtenleicht-api) [![Maintainability](https://api.codeclimate.com/v1/badges/9cfbefd386ea0eb065b1/maintainability)](https://codeclimate.com/github/Frederick-S/nachrichtenleicht-api/maintainability)
API of [nachrichtenleicht-mobile](https://github.com/Frederick-S/nachrichtenleicht-mobile).

## Getting started
### Docker
```sh
docker run -e MYSQL_ROOT_PASSWORD=your-mysql-root-password \
  -e MYSQL_DATABASE=nhk -e MYSQL_USER=your-mysql-user \
  -e MYSQL_PASSWORD=your-mysql-user-password \
  -p 3306:3306 \
  -d mysql:8

docker run -e MYSQL_HOST=ip-address-of-mysql (inspected from docker inspect mysql-container) \
  -e MYSQL_USER=your-mysql-user \
  -e MYSQL_PASSWORD=your-mysql-user-password \
  -p 8080:8080 xiaodanmao/nachrichtenleicht-api
```

### Docker compose
Run `cp .env.template .env` and modify user & password, then run `docker-compose up -d`.

## License
[MIT](LICENSE)
