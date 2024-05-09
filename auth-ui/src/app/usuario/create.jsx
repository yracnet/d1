import {
  Create,
  SimpleForm,
  TextInput,
  required,
  minLength,
  maxLength,
  email,
} from "react-admin";

const validateText = [required(), minLength(2), maxLength(15)];
const validateEmail = email();
export const UsuarioCreate = (props) => (
  <Create {...props}>
    <SimpleForm>
      <TextInput source="email" label="Correo" validate={validateEmail} />
      <TextInput source="nombres" label="Nombres" validate={validateText} />
      <TextInput source="apellidos" label="Apellidos" validate={validateText} />
      <TextInput source="descripcion" label="Descripción" />
    </SimpleForm>
  </Create>
);
