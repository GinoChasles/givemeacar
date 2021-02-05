import {
    Datagrid, Filter, List, NumberField, ReferenceInput, SearchInput, TextField, ReferenceField, useTranslate, EditButton, DeleteButton
} from "react-admin";

import * as React from "react";


const CarFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);


const DisplayCar = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.cars')} filters={<CarFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show">
            <TextField label={t('word.id')} source="id" />

            <ReferenceField link="show" label={t('word.brand')} source="brandId" reference="brands">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('word.model')} source="model_id" reference="models">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('word.color')} source="color_id" reference="colors">
                <TextField source="name" />
            </ReferenceField>

            <TextField label={t('word.energyLevel')} source="energyLevel" />

            <ReferenceField link="show" label={t('word.energy')} source="energy_type_id" reference="energy_types">
                <TextField source="name" />
            </ReferenceField>
            
            <NumberField label={t('word.year')} source="year" />

            <NumberField label={t('word.kilometers')} source="kilometers" />

            <NumberField label={t('word.price')} source="price" />

            <TextField label={t('word.energyLevel')} source="energyLevel" />

            <TextField label={t('word.available')} source="availability" />
            
            <TextField label={t('word.rented')} source="inRent" />

            <TextField label={t('word.latitude')} source="latitude" />
            
            <TextField label={t('word.longitude')} source="longitude" />

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayCar