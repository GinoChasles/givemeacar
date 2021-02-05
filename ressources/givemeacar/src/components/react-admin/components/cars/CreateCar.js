import * as React from "react";
import {
  NumberInput,
  Create,
  SimpleForm,
  ReferenceInput,
  useTranslate,
  AutocompleteInput,
  required
} from "react-admin";

const CreateCar = (props) => {

  const t = useTranslate();

  return <Create {...props} title={t('word.creation')}>
    <SimpleForm>

      <NumberInput label={t('word.kilometers')} source="kilometers" validate={[
        required(t('error.required'))
      ]} />

      <NumberInput label={t('word.pricePerMin')} source="price" validate={[
        required(t('error.required'))
      ]} />

      <NumberInput label={t('word.year')} source="year" validate={[
        required(t('error.required'))
      ]} />

      <NumberInput label={t('word.available')} source="available" validate={[
        required(t('error.required'))
      ]} />

      <NumberInput label={t('word.rented')} source="rented" validate={[
        required(t('error.required'))
      ]} />

      <ReferenceInput label={t('word.model')} source="model_id" reference="models" validate={[
        required(t('error.required'))
      ]}>
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <ReferenceInput label={t('word.color')} source="color_id" reference="colors" validate={[
        required(t('error.required'))
      ]}>
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <NumberInput label={t('word.energyMax')} source="energy_max" validate={[
        required(t('error.required'))
      ]} />

      <NumberInput label={t('word.energyCurrent')} source="energy_current" validate={[
        required(t('error.required'))
      ]} />

      <ReferenceInput label={t('word.energyType')} source="energy_type_id" reference="energy_types" validate={[
        required(t('error.required'))
      ]}>
        <AutocompleteInput optionText="name" optionValue={"id"} />
      </ReferenceInput>

      <NumberInput label={t('word.latitude')} source="latitude" validate={[
        required(t('error.required'))
      ]} />

      <NumberInput label={t('word.longitude')} source="longitude" validate={[
        required(t('error.required'))
      ]} />

    </SimpleForm>
  </Create>
}

export default CreateCar;