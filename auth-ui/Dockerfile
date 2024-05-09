FROM node:20 AS build

VOLUME /usr/local/share/.cache/yarn/

WORKDIR /app

COPY package.json yarn.lock ./

RUN yarn install --frozen-lockfile --prefer-offline

COPY . .

RUN yarn build

FROM nginx:alpine

COPY --from=build /app/dist/. /site/

COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
