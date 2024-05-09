import React from "react";
import { List, Datagrid, TextField, ReferenceField } from "react-admin";

export const PermisoList = (props) => (
  <List {...props}>
    <Datagrid rowClick="edit">
      <ReferenceField source="usuarioId" reference="usuario">
        <TextField source="email" />
      </ReferenceField>
      <TextField source="modulo" />
      <TextField source="permitido" />
    </Datagrid>
  </List>
);
