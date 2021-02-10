import { Datagrid, Filter, List, useTranslate, SearchInput, TextField, EditButton, DeleteButton } from "react-admin";
import * as React from "react";

const BrandFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayBrand = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.brands')} filters={<BrandFilter />} exporter={false} perPage={25}>
        <Datagrid hasBulkActions rowClick="show" >


            <TextField label={t('word.name')} source="name" />

            <EditButton />

            <DeleteButton />
        </Datagrid>
    </List>
}

export default DisplayBrand