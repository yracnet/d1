import React from "react";
import { List, Datagrid, TextField, EmailField } from "react-admin";

export const UsuarioList = (props) => (
  <List {...props}>
    <Datagrid rowClick="edit">
      <EmailField source="email" />
      <TextField source="nombres" />
      <TextField source="apellidos" />
      <TextField source="descripcion" />
    </Datagrid>
  </List>
);
