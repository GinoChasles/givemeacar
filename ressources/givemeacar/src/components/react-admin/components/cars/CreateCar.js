import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  ReferenceField,
  NumberInput,
  NumberField,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  BooleanInput,
  BooleanField,
  AutocompleteInput,
} from "react-admin";


//TODO problème sur l'avaibility et rent, ne demande pas un boolean mais un int

const CreateCar = (props) => (
  <Create {...props}>
    <SimpleForm>
      <NumberInput source="kilometers" />
      <NumberInput source="price" label="prix par minute" />
      <NumberInput source="year" />
      <NumberInput source="available" />
      <NumberInput source="rented"  />
      <ReferenceInput source="model_id" reference="models" >
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>
      <ReferenceInput source="color_id" reference="colors" >
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
      <NumberInput source="energy_max" />
      <NumberInput source="energy_current" />
      <ReferenceInput source="energy_type_id" reference="energy_types">
        <AutocompleteInput optionText="name" optionValue={"id"}/>
      </ReferenceInput>
      <NumberInput source="latitude" />
      <NumberInput source="longitude" />
    </SimpleForm>
  </Create>
);

export default CreateCar