import { AutocompleteInput, BooleanInput, Edit, NumberInput, ReferenceInput, SimpleForm, useTranslate } from "react-admin";
import * as React from "react";

const EditCar = (props) => {

    const t = useTranslate();

    return <Edit {...props} undoable={false} title={t('custom.edition')}>
        <SimpleForm>

            <NumberInput label={t('custom.kilometers')} source="kilometers" />

            <NumberInput label={t('custom.price')} source="price" />

            <NumberInput label={t('custom.year')} source="year" />

            <BooleanInput label={t('custom.available')} source="available" />

            <BooleanInput label={t('custom.rented')} source="rented" />

            <ReferenceInput label={t('custom.model')} source="model_id" reference="models">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <ReferenceInput label={t('custom.color')} source="color_id" reference="colors">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <NumberInput label={t('custom.energyMax')} source="energyMax" />

            <NumberInput label={t('custom.energyCurrent')} source="energyCurrent" />

            <ReferenceInput label={t('custom.energyType')} source="energy_type_id" reference="energy_types">
                <AutocompleteInput optionText="name" optionValue={"id"} />
            </ReferenceInput>

            <NumberInput label={t('custom.latitude')} source="latitude" />

            <NumberInput label={t('custom.longitude')} source="longitude" />
        </SimpleForm>
    </Edit>
}

export default EditCar;