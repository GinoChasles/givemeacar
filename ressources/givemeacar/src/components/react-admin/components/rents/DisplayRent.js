import {
    Datagrid, DateField, Filter, List, SearchInput, TextField, useTranslate, EditButton, DeleteButton
} from "react-admin";
import * as React from "react";

const RentFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayRent = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.rents')} filters={<RentFilter />} exporter={false} perPage={25}>
        <Datagrid rowClick="edit" hasBulkActions rowClick="show">


            <DateField label={t('word.rentStart')} source="start" showTime />

            <DateField label={t('word.rentEnd')} source="end" showTime />

            <TextField label={t('word.car')} source="car_id" />

            <TextField label={t('word.client')} source="client_id" />

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayRent