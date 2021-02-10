import { Datagrid, Filter, List, TextField, SearchInput, useTranslate, EditButton, DeleteButton } from "react-admin";
import * as React from "react";

const CountryFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayCountry = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.countries')} filters={<CountryFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show">


            <TextField label={t('word.name')} source="name" />

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayCountry