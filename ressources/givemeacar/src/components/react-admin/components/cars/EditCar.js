import {
    AutocompleteInput, required, Edit, NumberInput, BooleanInput, ReferenceInput, SimpleForm, useTranslate, SaveButton, Toolbar
} from "react-admin";
import * as React from "react";


const CarToolbar = props => (
    <Toolbar {...props}>
        <SaveButton submitOnEnter transform={(data) => {
            data.available = data.available === true ? 1 : 0;
            data.rented = data.rented === true ? 1 : 0;
            console.log(data)
            return data;
        }} />
    </Toolbar>
);

const EditCar = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('word.edition')} >
        <SimpleForm toolbar={<CarToolbar />}>

            <NumberInput label={t('word.kilometers')} source="kilometers" validate={[
                required(t('error.required'))
            ]} />

            <NumberInput label={t('word.pricePerMin')} source="price" validate={[
                required(t('error.required'))
            ]} />

            <NumberInput label={t('word.year')} source="year" validate={[
                required(t('error.required'))
            ]} />

            <BooleanInput label={t('word.available')} source="available" validate={[
                required(t('error.required'))
            ]} />

            <BooleanInput label={t('word.rented')} source="rented" validate={[
                required(t('error.required'))
            ]} />

            <ReferenceInput label={t('word.model')} source="model_id"
                filter={{ brand_id: 70 }}
                reference="models" validate={[
                required(t('error.required'))
            ]}>
                <AutocompleteInput optionText="fullName" optionValue={"id"} />
            </ReferenceInput>

            <ReferenceInput label={t('word.color')} source="color_id" reference="colors" validate={[
                required(t('error.required'))
            ]}>
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <NumberInput label={t('word.energyMax')} source="energyMax" validate={[
                required(t('error.required'))
            ]} />

            <NumberInput label={t('word.energyCurrent')} source="energyCurrent" validate={[
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
    </Edit>
}

export default EditCar;