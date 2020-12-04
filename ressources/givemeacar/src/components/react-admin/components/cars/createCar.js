import * as React from "react";
import {
  List,
  Datagrid,
  TextField,
  ReferenceField,
  EditButton,
  NumberInput,
  NumberField,
  Create,
  Edit,
  SimpleForm,
  ReferenceInput,
  BooleanInput,
  BooleanField,
  SelectInput,
  TextInput,
} from "react-admin";
export const DisplayCars = (props) => (
  <List {...props} title="Liste des véhicules">
    <Datagrid rowClick="edit">
      <NumberField source="kilometers" />
      <NumberField source="price" />
      <NumberField source="year" />
      <BooleanField source="available" default={true}/>
      <BooleanField source="rented" default={false}/>
      <TextField source="model_id" />
      <ReferenceField source="model_id" reference="models">
      <TextField source="name" /> 
      </ReferenceField>
      <TextField source="energy_id" />
      <TextField source="color_id" />
      <TextField source="energy_max" />
      <TextField source="energy_current" />
      <TextField source="energy_type_id" />
      <TextField source="latitude" />
      <TextField source="longitude" />
      <TextField source="number_suffix" />
    </Datagrid>
  </List>
);

//TODO problème sur l'avaibility et rent, ne demande pas un boolean mais un int
export const EditCars = (props) => (
  <Edit {...props}>
    <SimpleForm>
      <NumberInput source="kilometers" />
      <NumberInput source="price" />
      <NumberInput source="year" />
      <BooleanInput source="available" valueLabelTrue="La voiture est dispo" valueLabelFalse="la voiture est indisponible"/>
      <BooleanInput source="rented" valueLabelTrue="la voiture est louée" valueLabelFalse="la voiture n'est pas louée" />
      <ReferenceInput source="model_id" reference="models">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <ReferenceInput source="color_id" reference="colors">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <NumberInput source="energy_max" />
      <NumberInput source="energy_current" />
      <ReferenceInput source="energy_type_id" reference="energy_types">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <NumberInput source="latitude" />
      <NumberInput source="longitude" />
    </SimpleForm>
  </Edit>
);
export const CreateCars = (props) => (
  <Create {...props}>
    <SimpleForm>
      <NumberInput source="kilometers" />
      <NumberInput source="price" label="prix par minute" />
      <NumberInput source="year" />
      <NumberInput source="available" />
      <NumberInput source="rented"  />
      <ReferenceInput source="model_id" reference="models" >
        <SelectInput optionText="name"  />
      </ReferenceInput>
      <ReferenceInput source="color_id" reference="colors" >
        <SelectInput optionText="name" sortable={true} />
      </ReferenceInput>
      <NumberInput source="energy_max" />
      <NumberInput source="energy_current" />
      <ReferenceInput source="energy_type_id" reference="energy_types">
        <SelectInput optionText="name" />
      </ReferenceInput>
      <NumberInput source="latitude" />
      <NumberInput source="longitude" />
    </SimpleForm>
  </Create>
);
