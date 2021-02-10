import {
    Datagrid, Filter, List, BooleanField, SearchInput, TextField, ReferenceField, useTranslate, DeleteButton,
} from "react-admin";

import * as React from "react";

import ShowCar from './ShowCar';

const CarFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);


const DisplayCar = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.cars')} filters={<CarFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show" expand={ShowCar}>


            <ReferenceField link="show" label={t('word.brand')} source="brandId" reference="brands">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('word.model')} source="model_id" reference="models">
                <TextField source="name" />
            </ReferenceField>

            <BooleanField label={t('word.available')} source="available" />

            <BooleanField label={t('word.rented')} source="rented" />

            <TextField label={t('word.latitude')} source="latitude" />

            <TextField label={t('word.longitude')} source="longitude" />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayCar