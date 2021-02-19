import {
    Datagrid, Filter, List, NumberField, ReferenceInput,
    SearchInput, TextField, ReferenceField, BooleanField, useTranslate
} from "react-admin";

import * as React from "react";


const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="user_id" reference="users" allowEmpty>
            <SearchInput optionText="name" /> 
        </ReferenceInput>
    </Filter>
);


const DisplayCar = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('custom.cars')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.brand')} source="brandName" />

            <TextField label={t('custom.model')} source="modelName" />

            <TextField label={t('custom.color')} source="colorName" />

            <TextField label={t('custom.energyLevel')} source="energyLevel" />

            <TextField label={t('custom.energy')} source="energy" />
            
            <NumberField label={t('custom.year')} source="year" />

            <NumberField label={t('custom.kilometers')} source="kilometers" />

            <NumberField label={t('custom.price')} source="price" />

            <TextField label={t('custom.energyLevel')} source="energyLevel" />

            <BooleanField label={t('custom.available')} source="available" />
            
            <BooleanField label={t('custom.rented')} source="rented" />

            <TextField label={t('custom.latitude')} source="latitude" />
            
            <TextField label={t('custom.longitude')} source="longitude" />
        </Datagrid>
    </List>
}

export default DisplayCar