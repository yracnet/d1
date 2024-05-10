import jsonServerProvider from "ra-data-json-server";
import { fetchUtils } from "ra-core";

const PROVIDERS = {
  json: jsonServerProvider,
  simple: (
    apiUrl,
    httpClient = fetchUtils.fetchJson,
    countHeader = "Content-Range"
  ) => {
    return {
      // resource = ''
      getList: (resource, params) => {
        // console.log(">>>>>getList", resource, params);
        const options = {};
        return httpClient(`${apiUrl}/`, options).then(({ headers, json }) => {
          return {
            data: json,
            total: 100,
          };
        });
      },
      getOne: (resource, params) => {
        // console.log(">>>>>getOne", resource, params);
        return Promise.resolve({ data: {} });
      },
      getMany: (resource, params) => {
        console.log(">>>>>getMany", resource, params);
        // return aux.getMany(resource, params).then((r) => {
        //   console.log(">>>>>", r);
        //   return r;
        // });
        const requests = params.ids
          .map((id) => `${apiUrl}/${id}`)
          .map((url) =>
            fetch(url)
              .then((r) => r.json())
              .catch((e) => undefined)
          );
        return Promise.all(requests)
        .then((data) => {
          return {
            data: data.filter(it => it),
          };
        });
      },
      getManyReference: (resource, params) => {
        // console.log(">>>>>getManyReference", resource, params);
        return Promise.resolve({ data: [] });
      },
      update: (resource, params) => {
        // console.log(">>>>>update", resource, params);
        return Promise.resolve({ data: {} });
      },
      updateMany: (resource, params) => {
        // console.log(">>>>>updateMany", resource, params);
        return Promise.resolve({ data: {} });
      },
      create: (resource, params) => {
        // console.log(">>>>>create", resource, params);
        const options = {
          method: "POST",
          body: JSON.stringify({id:-1, ...params.data }),
        };
        return httpClient(`${apiUrl}/`, options).then(({ headers, json }) => {
          return {
            data: json,
          };
        });
      },
      delete: (resource, params) => {
        // console.log(">>>>>delete", resource, params);
        return Promise.resolve({ data: {} });
      },
      deleteMany: (resource, params) => {
        // console.log(">>>>>deleteMany", resource, params);
        return Promise.resolve({ data: {} });
      },
    };
  },
};

export const dataProvider = (config) => {
  let { mode, ...urls } = config;
  // console.log("MODE >>> ", mode);
  const serverProvider = PROVIDERS[mode] || jsonServerProvider;

  const provider = Object.entries(urls).reduce((result, [key, value]) => {
    result[key] = serverProvider(value);
    return result;
  }, {});

  const proxyMethod = (resource, method, params) => {
    if (provider[resource]) {
      return provider[resource][method](`?source=${resource}&`, params);
    } else {
      return provider.admin[method](resource, params);
    }
  };
  return {
    getList: (resource, params) => proxyMethod(resource, "getList", params),
    getOne: (resource, params) => proxyMethod(resource, "getOne", params),
    getMany: (resource, params) => proxyMethod(resource, "getMany", params),
    getManyReference: (resource, params) =>
      proxyMethod(resource, "getManyReference", params),
    update: (resource, params) => proxyMethod(resource, "update", params),
    updateMany: (resource, params) =>
      proxyMethod(resource, "updateMany", params),
    create: (resource, params) => proxyMethod(resource, "create", params),
    delete: (resource, params) => proxyMethod(resource, "delete", params),
    deleteMany: (resource, params) =>
      proxyMethod(resource, "deleteMany", params),
  };
};
