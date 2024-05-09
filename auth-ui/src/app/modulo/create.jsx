import {
  Create,
  SimpleForm,
  required,
  minLength,
  maxLength,
  TextInput,
} from "react-admin";

const validateNombre = [required(), minLength(2), maxLength(15)];
const validateCodigo = [required(), minLength(2), maxLength(50)];
export const ModuloCreate = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="codigo" label="Codigo" validate={validateCodigo} />
      <TextInput source="nombre" label="Nombre" validate={validateNombre} />
    </SimpleForm>
  </Create>
);
