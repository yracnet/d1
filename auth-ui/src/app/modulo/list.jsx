import React from "react";
import { List, Datagrid, TextField, ReferenceField } from "react-admin";

export const ModuloList = (props) => (
  <List {...props}>
    <Datagrid rowClick="edit">
      <TextField source="codigo" />
      <TextField source="nombre" />
    </Datagrid>
  </List>
);
