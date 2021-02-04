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

    return <List {...props} title={t('word.rents')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('word.id')} source="id" />

            <DateField label={t('word.rentStart')} source="start" showTime />

            <DateField label={t('word.rentEnd')} source="end" showTime />

            <TextField label={t('word.car')} source="car_id" />

            <TextField label={t('word.client')} source="client_id" />
        </Datagrid>
    </List>
}

export default DisplayRent