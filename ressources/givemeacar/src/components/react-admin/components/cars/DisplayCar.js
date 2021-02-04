import {
    Datagrid, Filter, List, NumberField, ReferenceInput, SearchInput, TextField, ReferenceField, useTranslate
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

            <ReferenceField link="show" label={t('custom.brand')} source="brandId" reference="brands">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('custom.model')} source="model_id" reference="models">
                <TextField source="name" />
            </ReferenceField>

            <ReferenceField link="show" label={t('custom.color')} source="color_id" reference="colors">
                <TextField source="name" />
            </ReferenceField>

            <TextField label={t('custom.energyLevel')} source="energyLevel" />

            <ReferenceField link="show" label={t('custom.energy')} source="energy_type_id" reference="energy_types">
                <TextField source="name" />
            </ReferenceField>
            
            <NumberField label={t('custom.year')} source="year" />

            <NumberField label={t('custom.kilometers')} source="kilometers" />

            <NumberField label={t('custom.price')} source="price" />

            <TextField label={t('custom.energyLevel')} source="energyLevel" />

            <TextField label={t('custom.available')} source="availability" />
            
            <TextField label={t('custom.rented')} source="inRent" />

            <TextField label={t('custom.latitude')} source="latitude" />
            
            <TextField label={t('custom.longitude')} source="longitude" />
        </Datagrid>
    </List>
}

export default DisplayCar