import * as React from "react";
import {
  NumberInput,
  Create,
  SimpleForm,
  ReferenceInput,
  useTranslate,
  AutocompleteInput,
} from "react-admin";

const CreateCar = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('custom.creation')}>
    <SimpleForm>

      <NumberInput label={t('custom.kilometers')} source="kilometers" />

      <NumberInput label={t('custom.pricePerMin')} source="price" />

      <NumberInput label={t('custom.year')} source="year" />

      <NumberInput label={t('custom.available')} source="available" />

      <NumberInput label={t('custom.rented')} source="rented" />

      <ReferenceInput label={t('custom.model')} source="model_id" reference="models" >
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput label={t('custom.color')} source="color_id" reference="colors" >
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <NumberInput label={t('custom.energyMax')} source="energy_max" />

      <NumberInput label={t('custom.energyCurrent')} source="energy_current" />

      <ReferenceInput label={t('custom.energyType')} source="energy_type_id" reference="energy_types">
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <NumberInput label={t('custom.latitude')} source="latitude" />

      <NumberInput label={t('custom.longitude')} source="longitude" />

    </SimpleForm>
  </Create>
}

export default CreateCar;