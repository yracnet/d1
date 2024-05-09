import {
  Create,
  SimpleForm,
  ReferenceInput,
  SelectInput,
  BooleanInput,
} from "react-admin";

export const PermisoCreate = (props) => (
  <Create {...props}>
    <SimpleForm>
      <ReferenceInput source="usuarioId" reference="usuario">
        <SelectInput optionText="nombres" />
      </ReferenceInput>
      <SelectInput
        source="modulo"
        choices={[
          { name: "Gestión de clientes", id: "cliente" },
          { name: "Gestión de cuentas", id: "cuenta" },
          { name: "Transferencias", id: "transferencia" },
          { name: "Préstamos", id: "prestamo" },
          { name: "Banca en línea", id: "banca_en_linea" },
        ]}
      />
      <BooleanInput source="permitido" />
    </SimpleForm>
  </Create>
);
