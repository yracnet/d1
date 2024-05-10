import { Admin, Resource } from "react-admin";
import { UsuarioList } from "./usuario/list";
import { PermisoList } from "./permiso/list";
import { UsuarioCreate } from "./usuario/create";
import { PermisoCreate } from "./permiso/create";
import { i18nProvider } from "./i18n";
import { dataProvider } from "./data";
import { ModuloList } from "./modulo/list";
import { ModuloCreate } from "./modulo/create";
import { useEffect, useState } from "react";

export const App = () => {
  const [config, setConfig] = useState(false);
  const [error, setError] = useState(false);
  useEffect(() => {
    fetch(`${import.meta.env.BASE_URL}provider.json`)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setConfig(data);
      })
      .catch((error) => {
        setError(error.message);
      });
  }, []);

  return error ? (
    <pre>{error}</pre>
  ) : config ? (
    <Admin
      dataProvider={dataProvider(config)}
      title="AUTH-UI"
      locale="es"
      i18nProvider={i18nProvider}
    >
      <Resource name="usuario" list={UsuarioList} create={UsuarioCreate} />
      <Resource name="permiso" list={PermisoList} create={PermisoCreate} />
      <Resource name="module" list={ModuloList} create={ModuloCreate} />
    </Admin>
  ) : (
    <h1>Cargando....</h1>
  );
};
