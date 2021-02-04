import {
    Datagrid, DateField, Filter, List, SearchInput, TextField, useTranslate
} from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayRent = (props) => {

    const t = useTranslate();

    return <List {...props} title="Réservation" filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <DateField label={t('custom.rentStart')} source="start" showTime />
            <DateField label={t('custom.rentEnd')} source="end" showTime />
            <TextField label={t('custom.car')} source="car_id" />
            <TextField label={t('custom.client')} source="client_id" />
        </Datagrid>
    </List>
}

export default DisplayRent